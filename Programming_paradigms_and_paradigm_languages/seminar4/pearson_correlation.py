'''
Написать скрипт для расчета корреляции Пирсона между
двумя случайными величинами (двумя массивами). Можете
использовать любую парадигму, но рекомендую использовать
функциональную, т.к. в этом примере она значительно
упростит вам жизнь.
'''

def mean(values):
    return sum(values) / len(values)

def pearson_correlation(x, y):
    mean_x = mean(x)
    mean_y = mean(y)
    
    numerator = sum((x[i] - mean_x) * (y[i] - mean_y) for i in range(len(x)))
    denominator_x = (sum((x[i] - mean_x)**2 for i in range(len(x))))**0.5
    denominator_y = (sum((y[i] - mean_y)**2 for i in range(len(y))))**0.5
    
    correlation = numerator / (denominator_x * denominator_y)
    return correlation

# Пример данных
array1 = [1, 2, 3, 4, 5]
array2 = [5, 4, 3, 2, 1]

correlation_coefficient = pearson_correlation(array1, array2)
print("Коэффициент корреляции Пирсона:", correlation_coefficient)
