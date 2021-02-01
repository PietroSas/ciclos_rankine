from CoolProp.CoolProp import PropsSI
import matplotlib.pyplot as plt

def rankine_reaquecido(p1, p3, p4, t3, fluido):
    
    if t3 == 272.15:
        t3 = PropsSI('T', 'P', p3, 'Q', 1, fluido)

    #Estado 1
    h1 = PropsSI('H', 'P|liquid', p1, 'Q', 0, fluido) #Entalpia 1
    s1 = PropsSI('S', 'P|liquid', p1, 'Q', 0, fluido) #Entropia 1
    
    #Estado 2
    p2 = p3 #Compressão
    s2 = s1 #Processo Isoentrópico
    h2 = PropsSI('H', 'P|liquid', p2, 'S', s2, fluido) #Entalpia 2    
    
    #Estado 3
    h3 = PropsSI('H', 'P|gas', p3, 'T', t3, fluido)
    s3 = PropsSI('S', 'P|gas', p3, 'T', t3, fluido)

    #Estado 4
    s4 = s3
    h4 = PropsSI('H', 'P|gas', p4, 'S', s4, fluido)  
    
    #Para cálculo do título:
    s4l = PropsSI('S', 'P|liquid', p4, 'Q', 0, fluido)
    s4v = PropsSI('S', 'P|gas', p4, 'Q', 1, fluido)
    
    if (s4 < s4v):
        x4 = (s4 - s4l)/(s4v - s4l)
    else:
        x4 = 'Saída da turbina superaquecida'
    
    #Estado 5
    p5 = p4
    t5 = t3
    h5 = PropsSI('H', 'P|gas', p5, 'T', t5, fluido)
    s5 = PropsSI('S', 'P|gas', p5, 'T', t5, fluido)

    #Estado 6
    s6 = s5
    p6 = p1
    h6 = PropsSI('H', 'P|gas', p6, 'S', s6, fluido)  
    
    #Para cálculo do título:
    s6l = PropsSI('S', 'P|liquid', p6, 'Q', 0, fluido)
    s6v = PropsSI('S', 'P|gas', p6, 'Q', 1, fluido)
    
    if (s6 < s6v):
        x6 = (s6 - s6l)/(s6v - s6l)
    else:
        x6 = 'Saída da turbina superaquecida'

    
    #Parâmetros de Saída
    wb = h2 - h1 #Trabalho na bomba
    wt1 = h3 - h4 #Trabalho na turbina 1
    wt2 = h5 - h6 #Trabalho na turbina 2
    wt = wt1 + wt2 #Trabalho total realizado
    w = wt - wb #Trabalho Líquido
    qh = (h3 - h2) + (h5 - h4) #Calor de Entrada
    ql = h6 - h1 #Calor rejeitado
    n = (qh - ql)/qh #Rendimento
    
    #Padronizando unidades
    h1 = round(h1/1000, 2)
    h2 = round(h2/1000, 2)
    h3 = round(h3/1000, 2)
    h4 = round(h4/1000, 2)
    h5 = round(h5/1000, 2)
    h6 = round(h6/1000, 2)
    wt1 = round(wt1/1000, 2)
    wt2 = round(wt2/1000, 2)
    wt = round(wt/1000, 2)
    wb = round(wb/1000, 2)
    w = round(w/1000, 2)
    qh = round(qh/1000, 2)
    ql = round(ql/1000, 2)
    if type(x4) == float:
        x4 = round(x4*100, 2)
    if type(x6) == float:
        x6 = round(x6*100, 2)
    n = round(n*100, 2)
    
    return {'h1':h1, 'h2':h2, 'h3':h3, 'h4':h4, 'h5':h5, 
            'h6':h6, 'wt':wt, 'wb':wb, 'w':w, 'qh':qh, 'ql':ql, 
            'x4':x4, 'x6':x6, 'n':n}

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
        s = rankine_reaquecido(p_baixa, p_alta, p_intermediaria, t_alta, fluido)
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
print('\n  **** CICLO RANKINE COM REAQUECIMENTO ****')
print("\n-------------- Dados de Entrada --------------\n")
p1 = float(input("Insira a pressão inferior do sistema (kPa): "))
p4 = float(input("Insira a pressão intermediária do sistema (kPa): "))
p3 = float(input("Insira a pressão superior do sistema (kPa): "))
t3 = float(input("Insira a temperatura superior do sistema (ºC) [Insira -1 para Vapor Saturado]: "))
fluido = 'Water'

p1 *= 1000
p3 *= 1000
p4 *= 1000
t3 += 273.15

s = rankine_reaquecido(p1, p3, p4, t3, fluido) #Saídas
maximos = otimizacao(p1, p3, t3, fluido)

#Imprimindo os resultados
print("\n----------------- Resultados -----------------\n")
print(f"""Entalpia 1: {s['h1']} kJ/kg
Entalpia 2 {s['h2']} kJ/kg
Entalpia 3: {s['h3']} kJ/kg
Entalpia 4: {s['h4']} kJ/kg
Entalpia 5: {s['h5']} kJ/kg
Entalpia 6: {s['h6']} kJ/kg
Trabalho Bomba: {s['wb']} kJ/kg
Trabalho Turbina: {s['wt']} kJ/kg
Trabalho Líquido: {s['w']} kJ/kg
Calor Entrada: {s['qh']} kJ/kg
Calor Rejeitado: {s['ql']} kJ/kg
Título Turbina 1: {s['x4']}%
Título Turbina 2: {s['x6']}%
Rendimento: {s['n']}%\n""")

print("------------- Pontos de Otimização -------------\n")
print(f"""Pressão Intermediária de maior trabalho: {maximos['p_trabalho_max']:.2f} kPa
Trabalho máximo: {maximos['trabalho_max']:.2f} kJ/kg
Pressão Intermediária de maior rendimento: {maximos['p_rendimento_max']:.2f} kPa
Rendimento máximo: {maximos['rendimento_max']:.2f}%\n""")
