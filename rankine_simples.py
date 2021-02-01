from CoolProp.CoolProp import PropsSI

def rankine_simples(p1, p3, t3, fluido):
    
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
    p4 = p1
    h4 = PropsSI('H', 'P|gas', p4, 'S', s4, fluido)  
    
    #Para cálculo do título:
    s4l = PropsSI('S', 'P|liquid', p4, 'Q', 0, fluido)
    s4v = PropsSI('S', 'P|gas', p4, 'Q', 1, fluido)
    
    if (s4 < s4v):
        x4 = (s4 - s4l)/(s4v - s4l)
    else:
        x4 = 'Saída da turbina superaquecida'
    
    #Parâmetros de Saída
    wb = h2 - h1 #Trabalho na bomba
    wt = h3 - h4 #Trabalho na turbina
    w = wt - wb #Trabalho líquido
    qh = h3 - h2 #Calor de Entrada
    ql = h4 - h1 #Calor rejeitado
    n = (qh - ql)/qh #Rendimento
    
    #Padronizando unidades
    h1 = round(h1/1000, 2)
    h2 = round(h2/1000, 2)
    h3 = round(h3/1000, 2)
    h4 = round(h4/1000, 2)
    wt = round(wt/1000, 2)
    wb = round(wb/1000, 2)
    w = round(w/1000, 2)
    qh = round(qh/1000, 2)
    ql = round(ql/1000, 2)
    if type(x4) == float:
        x4 = round(x4*100, 2)
    n = round(n*100, 2)
    
    return {'h1':h1, 'h2':h2, 'h3':h3, 'h4':h4, 'wt':wt,
            'w':w, 'wb':wb, 'qh':qh, 'ql':ql, 'x4':x4,
            'n':n}

#Função Principal

#Parâmetros de Entrada
print('\n  ****** CICLO RANKINE SIMPLES ******')
print("\n-------------- Dados de Entrada --------------\n")
p1 = float(input("Insira a pressão inferior do sistema (kPa): "))
p3 = float(input("Insira a pressão superior do sistema (kPa): "))
t3 = float(input("Insira a temperatura superior do sistema (ºC) [Insira -1 para Vapor Saturado]: "))
fluido = 'Water'

p1 *= 1000
p3 *= 1000
t3 += 273.15

s = rankine_simples(p1, p3, t3, fluido) #Saídas


#Imprimindo os resultados
print("\n----------------- Resultados -----------------\n")
print(f"""Entalpia 1: {s['h1']} kJ/kg
Entalpia 2 {s['h2']} kJ/kg
Entalpia 3: {s['h3']} kJ/kg
Entalpia 4: {s['h4']} kJ/kg
Trabalho Bomba: {s['wb']} kJ/kg
Trabalho Turbina: {s['wt']} kJ/kg
Trabalho Líquido: {s['w']} kJ/kg
Calor Entrada: {s['qh']} kJ/kg
Calor Rejeitado: {s['ql']} kJ/kg
Título Turbina: {s['x4']}%
Rendimento: {s['n']}%\n""")
