from collections import deque

def compare(tar_word, origin_word, trans_word):
    count = 0
    for i in range(len(tar_word)):
        if origin_word[i] != trans_word[i] :
            count += 1
    return count

def solution(begin, target, words):
    if target not in words:
        return 0
    target_idx = words.index(target)
    words = [(words[i], i) for i in range(len(words))]


    queue = deque([(begin, 0)])
    visited = [0] * len(words)
    

    bfs(queue, target, words, visited)

    return visited[target_idx]



def bfs(queue, target, words, visited):
    while queue:
        node = queue.popleft()

        for word in words:
            if compare(target, node[0], word[0]) == 1 and visited[word[1]] == 0:
                queue.append(word)
                visited[word[1]] = visited[node[1]] + 1