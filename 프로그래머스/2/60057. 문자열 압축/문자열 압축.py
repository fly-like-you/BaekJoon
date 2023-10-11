def solution(s):
    count = float('inf')
    if len(s) == 1:
        return 1
    for i in range(1, (len(s) // 2) + 1):
        string_len = string_zip(s, i)
        if string_len < count:
            count = string_len
    return count


def string_zip(string, unit_size):
    # pointer
    cur_p = 0
    diff_check_p = cur_p + unit_size
    ret_val = ""
    while True:


        chunk = string[cur_p:cur_p+unit_size]
        count = 1
        while True:
            next_chunk = string[diff_check_p:diff_check_p+unit_size]
            if next_chunk == chunk:
                diff_check_p += unit_size
                count += 1
            else:
                break

        if count == 1:
            ret_val += chunk
        else:
            ret_val += str(count) + chunk

        if not string[diff_check_p:]:
            break
        cur_p = diff_check_p
        diff_check_p = cur_p + unit_size
    return len(ret_val)