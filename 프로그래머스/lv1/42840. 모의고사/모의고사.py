def solution(answers):
    question_count = len(answers)

    li = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5, ], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    for i in range(3):
        length = len(li[i])
        repitition = question_count // length + 1
        remainder = question_count % length
        li[i] = li[i] * repitition
        for j in range(remainder):
            li[i].append(li[i][j])
    count = [[1, 0], [2, 0], [3, 0]]
    for i in range(question_count):
        if answers[i] == li[0][i]:
            count[0][1] += 1
        if answers[i] == li[1][i]:
            count[1][1] += 1
        if answers[i] == li[2][i]:
            count[2][1] += 1

    count.sort(key=lambda x: x[1],reverse=True)
    winner = [count[0][0]]
    for i in range(1,3):
        if count[0][1] == count[i][1]:
            winner.append(count[i][0])


    return winner

