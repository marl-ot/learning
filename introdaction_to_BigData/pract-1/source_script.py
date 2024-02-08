import json

n, mean, M2 = 0, 0.0, 0
for path in Path('imdb-user-reviews').glob('**/*'):
    if path.is_file() and path.suffix == '.json':
        with open(path, 'r') as f:
            info = json.load(f)
        score = float(info['movieIMDbRating'])
        n += 1
        delta = score - mean
        mean += delta / n
        M2 += delta * (score - mean)

print(mean, (M2 / n) ** (1/2))