import sys


# def solve(t, ss):
#     def output(s):
#         s = s.rstrip()
#         letters = set(s)
#         if len(letters) == 1:
#             return "-1"
#         return ''.join(sorted(s))
#     return map(output, ss)
#
#
# if __name__ == '__main__':
#     t = input()
#     ss = sys.stdin.readlines()
#     res = solve(t, ss)
#     for s in res:
#         print(s)

def solve(s):
    letters = set(s)
    return -1 if len(letters) == 1 else ''.join(sorted(s))


ss = sys.stdin.read().splitlines()[1:]
for s in ss:
    print(solve(s))

# #Golfed:
# for i in range(int(input())):
#     s = input()
#     print(-1 if len(set(s)) == 1 else ''.join(sorted(s)))
