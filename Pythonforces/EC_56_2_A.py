t = int(input())
xs = list(map(lambda _: int(input()), range(0, t)))


def ceil(a, b):
    return (a - 1)//b + 1


def result(x):
    return ceil(x, 7)


for x in xs:
    print(result(x))
