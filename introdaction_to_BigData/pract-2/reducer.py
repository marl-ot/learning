#!/usr/bin/env python
import sys

sum_price = 0
sum_squares = 0
count = 0

for line in sys.stdin:
    price, value = line.strip().split('\t')
    price = int(price)
    value = int(value)
    
    sum_price += price
    sum_squares += price ** 2
    count += value

avg_price = sum_price / count
var_price = (sum_squares / count) - (avg_price ** 2)

print(f"Average Price: {avg_price}\nVariance of Price: {var_price}")