def solution(people, limit):
    people.sort()
    boat = 0
    left_p, right_p = 0, len(people) - 1
    while True:
        if left_p > right_p:
            break
        elif left_p == right_p:
            boat += 1
            break

        load_sum = people[left_p] + people[right_p]
        if load_sum > limit: # 무게 합이 제한을 어기는 경우 1명만 태움
            right_p -= 1
        else:
            left_p += 1
            right_p -= 1
        boat += 1
    return boat