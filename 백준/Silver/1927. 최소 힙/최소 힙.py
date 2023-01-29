import sys
input = sys.stdin.readline


class Heap:
    def __init__(self):
        self.heap = []
        self.heap.append(None)
    def isLeaf(self, idx):
        left_node_idx = idx * 2
        if len(self.heap) <= left_node_idx: # 둘다 없을 때
            return True
        else:
            return False

    def check_swap_up(self, idx):
        if idx <= 1:
            return False
        parent_idx = idx // 2

        if self.heap[idx] > self.heap[parent_idx]:
            return True
        else:
            return False
    def add(self, target):
        idx = len(self.heap)
        self.heap.append(target)
        while self.check_swap_up(idx):

            self.heap[idx], self.heap[idx // 2] = self.heap[idx // 2], self.heap[idx]
            idx //= 2


    def delete(self):
        if len(self.heap) == 1:
            print(0)
            return
        print(self.heap[1] * -1)
        self.heap[-1], self.heap[1] = self.heap[1], self.heap[-1]
        del self.heap[-1]
        if len(self.heap) == 1:
            return
        idx = 1
        while not self.isLeaf(idx): # 자식 노드가 존재하지 않을 때 까지 반복
            left_idx = idx * 2
            right_idx = idx * 2 + 1
            try:
                val = self.heap[right_idx]
            except:
                val = -(2**31 + 1)

            if self.heap[left_idx] >= val: # 오른쪽 왼쪽 비교
                if self.heap[left_idx] > self.heap[idx]:
                    self.heap[left_idx], self.heap[idx] = self.heap[idx], self.heap[left_idx]  # 자식이 큰경우 변경
                    idx *= 2
                else:
                    break
            else: # 오른쪽 노드가 큰경우

                if self.heap[right_idx] > self.heap[idx]:
                    self.heap[right_idx], self.heap[idx] = self.heap[idx], self.heap[right_idx]  # 자식이 큰경우 변경
                    idx = idx * 2 + 1
                else:
                    break



heap = Heap()
N = int(input())
for _ in range(N):
    cmd = int(input())

    if cmd == 0:
        heap.delete()
    elif cmd == -1:
        print(heap.heap)
    else:
        heap.add(cmd * -1)

