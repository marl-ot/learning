#!/usr/bin/env python
import sys

for line in sys.stdin:
    fields = line.strip().split(',')
    price = fields[9]
    print(f"{price}\t1")