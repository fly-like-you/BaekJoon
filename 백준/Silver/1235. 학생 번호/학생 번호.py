N = int(input())
student_list = [input() for _ in range(N)]
length = len(student_list[0])

for j in range(1, length+1):
    stu_set = set()
    for i in range(N):
        stu_set.add(student_list[i][-j:])
    if len(stu_set) == N:
        print(j)
        exit()

