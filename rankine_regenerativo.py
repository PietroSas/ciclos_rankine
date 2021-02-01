from CoolProp.CoolProp import PropsSI
import matplotlib.pyplot as plt

def rankine_regenerativo(p1, p3, p5, t5, fluido):
    
    if t5 == 272.15:
        t5 = PropsSI('T', 'P', p5, 'Q', 1, fluido)

    #Estado 1
    h1 = PropsSI('H', 'P|liquid', p1, 'Q', 0, fluido) #Entalpia 1
    s1 = PropsSI('S', 'P|liquid', p1, 'Q', 0, fluido) #Entropia 1
    
    #Estado 2
    p2 = p3 #Compressão
    s2 = s1 #Processo Isoentrópico
    h2 = PropsSI('H', 'P|liquid', p2, 'S', s2, fluido) #Entalpia 2    
    
    #Estado 3
    h3 = PropsSI('H', 'P|liquid', p3, 'Q', 0, fluido) #Entalpia 3
    s3 = PropsSI('S', 'P|liquid', p3, 'Q', 0, fluido) #Entropia 3

    #Estado 4
    s4 = s3
    p4 = p5
    h4 = PropsSI('H', 'P|liquid', p4, 'S', s4, fluido)  
    
    #Estado 5
    h5 = PropsSI('H', 'P|gas', p5, 'T', t5, fluido) 
    s5 = PropsSI('S', 'P|gas', p5, 'T', t5, fluido) 
    
    #Estado 6
    p6 = p3
    s6 = s5
    h6 = PropsSI('H', 'P|gas', p6, 'S', s6, fluido) 
    
    #Para cálculo do título ponto 6:
    s6l = PropsSI('S', 'P|liquid', p6, 'Q', 0, fluido)
    s6v = PropsSI('S', 'P|gas', p6, 'Q', 1, fluido)
    
    if (s6 < s6v):
        x6 = (s6 - s6l)/(s6v - s6l)
    else:
        x6 = 'Saída da turbina superaquecida'
    
    #Estado 7
    p7 = p1
    s7 = s6
    h7 = PropsSI('H', 'P|gas', p7, 'S', s7, fluido) 
    
    #Para cálculo do título ponto 7:
    s7l = PropsSI('S', 'P|liquid', p7, 'Q', 0, fluido)
    s7v = PropsSI('S', 'P|gas', p7, 'Q', 1, fluido)
    
    if (s7 < s7v):
        x7 = (s7 - s7l)/(s7v - s7l)
    else:
        x7 = 'Saída da turbina superaquecida'
    
    #Fração mássica da extração
    m = (h3 - h2)/(h6 - h2)
    
    #Parâmetros de Saída
    wb1 = h2 - h1 #Trabalho na bomba 1
    wb2 = h4 - h3 #Trabalho na bomba 2
    wb = wb1 + wb2 #Trabalho nas bombas
    wt = (h5 - h6) + (1-m)*(h6 - h7) #Trabalho na turbina
    w = wt - wb #Trabalho líquido
    qh = h5 - h4  #Calor de Entrada
    ql = (1-m)*(h7 - h1) #Calor rejeitado
    n = (qh - ql)/qh #Rendimento
    
    #Padronizando unidades
    h1 = round(h1/1000, 2)
    h2 = round(h2/1000, 2)
    h3 = round(h3/1000, 2)
    h4 = round(h4/1000, 2)
    h5 = round(h5/1000, 2)
    h6 = round(h6/1000, 2)
    h7 = round(h7/1000, 2)
    wt = round(wt/1000, 2)
    wb = round(wb/1000, 2)
    w = round(w/1000, 2)
    qh = round(qh/1000, 2)
    ql = round(ql/1000, 2)
    if type(x6) == float:
        x6 = round(x6*100, 2)
    if type(x7) == float:
        x7 = round(x7*100, 2)
    n = round(n*100, 2)
    m = round(m*100, 2)
    
    return {'h1':h1, 'h2':h2, 'h3':h3, 'h4':h4, 'h5':h5, 
            'h6':h6, 'h7':h7,'wt':wt, 'wb':wb, 'w':w, 'qh':qh, 
            'ql':ql, 'x6':x6, 'x7':x7, 'n':n, 'm':m}

#Função de busca dos pontos ótimos
def otimizacao(p_baixa, p_alta, t_alta, fluido):
    lista_trabalhos = []
    lista_rendimentos = []
    lista_pressoes = []
    intervalo_pressao = p_alta - p_baixa
    divisoes = 1000
    passo = intervalo_pressao / divisoes
    
    for iteracao in range( 0, divisoes + 1 ):
        p_intermediaria = p_baixa + iteracao * passo        
        
        s = rankine_regenerativo(p_baixa, p_intermediaria, p_alta, t_alta, fluido)
        lista_pressoes.append(p_intermediaria / 1000)
        lista_trabalhos.append(s['w'])
        lista_rendimentos.append(s['n'])

    #Ponto de maior produção de trabalho   
    idx_trabalho = lista_trabalhos.index(max(lista_trabalhos))
    trabalho_max = lista_trabalhos[idx_trabalho] 
    p_trabalho_max = lista_pressoes[idx_trabalho]

    #Ponto de maior rendimento
    idx_rendimento = lista_rendimentos.index(max(lista_rendimentos))
    rendimento_max = lista_rendimentos[idx_rendimento]
    p_rendimento_max = lista_pressoes[idx_rendimento]   
    
    
    return {'trabalho_max':trabalho_max, 'p_trabalho_max':p_trabalho_max,
            'rendimento_max':rendimento_max, 'p_rendimento_max':p_rendimento_max}
    
    
#Função Principal

#Parâmetros de Entrada
print('\n  ***** CICLO RANKINE REGENERATIVO *****')
print("\n-------------- Dados de Entrada --------------\n")
p1 = float(input("Insira a pressão inferior do sistema (kPa): "))
p3 = float(input("Insira a pressão intermediária do sistema (kPa): "))
p5 = float(input("Insira a pressão superior do sistema (kPa): "))
t5 = float(input("Insira a temperatura superior do sistema (ºC) [Insira -1 para Vapor Saturado]: "))
fluido = 'Water'

p1 *= 1000
p3 *= 1000
p5 *= 1000
t5 += 273.15

s = rankine_regenerativo(p1, p3, p5, t5, fluido) #Saídas
maximos = otimizacao(p1, p5, t5, fluido)

#Imprimindo os resultados
print("\n----------------- Resultados -----------------\n")
print(f"""Entalpia 1: {s['h1']} kJ/kg
Entalpia 2: {s['h2']} kJ/kg
Entalpia 3: {s['h3']} kJ/kg
Entalpia 4: {s['h4']} kJ/kg
Entalpia 5: {s['h5']} kJ/kg
Entalpia 6: {s['h6']} kJ/kg
Entalpia 7: {s['h7']} kJ/kg
Trabalho Bomba: {s['wb']} kJ/kg
Trabalho Turbina: {s['wt']} kJ/kg
Trabalho Líquido: {s['w']} kJ/kg
Calor Entrada: {s['qh']} kJ/kg
Calor Rejeitado: {s['ql']} kJ/kg
Título Turbina 1: {s['x6']}%
Título Turbina 2: {s['x7']}%
Fração de extração: {s['m']}%
Rendimento: {s['n']}%\n""")

print("------------- Pontos de Otimização -------------\n")
print(f"""Pressão Intermediária de maior trabalho: {maximos['p_trabalho_max']:.2f} kPa
Trabalho máximo: {maximos['trabalho_max']:.2f} kJ/kg
Pressão Intermediária de maior rendimento: {maximos['p_rendimento_max']:.2f} kPa
Rendimento máximo: {maximos['rendimento_max']:.2f}%\n""")
