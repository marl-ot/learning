from pathlib import Path
import json
from functools import reduce

def mapper(path):
    with open(path, 'r') as f:
        info = json.load(f)
    score = float(info['movieIMDbRating'])
    return (score,)

def reducer(score_data1, score_data2):
    n1, mean1, M21 = score_data1
    n2, mean2, M22 = score_data2

    n = n1 + n2
    delta = mean2 - mean1
    mean = (n1 * mean1 + n2 * mean2) / n
    M2 = M21 + M22 + delta**2 * n1 * n2 / n

    return n, mean, M2

n, mean, M2 = reduce(reducer, map(mapper, Path('imdb-user-reviews').glob('**/*.json')))
print(mean, (M2 / n) ** (1/2))
