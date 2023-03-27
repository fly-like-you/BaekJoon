import sys

input = sys.stdin.readline

# T = int(input())

# command = []
# for _ in range(T):
#     k = int(input())
#     for _ in range(k):
#         pass


class PriorityQueue:

    def __init__(self):
        self.min_heap = MinHeap()
        self.max_heap = MaxHeap()

    def delete(self, flag):
        if flag == 1:
            max_val = self.max_heap.pop()
            self.min_heap.delete(max_val)
        else:
            min_val = self.min_heap.pop()
            self.max_heap.delete(min_val)

    def insert(self, num):
        self.min_heap.insert(num)
        self.max_heap.insert(num)


class MinHeap:

    def __init__(self):
        self.heap = HeapList()

    def delete(self, num):  # num을 힙에서 찾아서 삭제
        if self.__is_heap_empty():
            return
        idx = self.heap.get_value_idx(num)
        self.heap.swap(idx, -1)
        self.heap.pop()
        self.__top_down_heapify(idx)

    def pop(self):  # 최솟값을 삭제하는 연산
        if self.__is_heap_empty():
            print(0)
            return

        self.heap.swap(1, -1)  # 루트와 단말 교환
        min_val = self.heap.pop()
        self.__top_down_heapify(1)


        return min_val

    def insert(self, num):  # 삽입 연산
        self.heap.append(num)
        last_node_idx = self.heap.get_heap_size()  # 힙이 비어있으면 0
        self.__bottom_up_heapify(last_node_idx)

    def __top_down_heapify(self, idx):
        left_child_idx = self.heap.get_left_child_idx(idx)
        right_child_idx = self.heap.get_right_child_idx(idx)
        smallest = idx

        if left_child_idx <= self.heap.get_heap_size() and self.heap.get_value(left_child_idx) < self.heap.get_value(idx):
            smallest = left_child_idx

        if right_child_idx <= self.heap.get_heap_size() and self.heap.get_value(right_child_idx) < self.heap.get_value(smallest):
            smallest = right_child_idx

        if smallest != idx:
            self.heap.swap(idx, smallest)
            self.__top_down_heapify(smallest)

    def __bottom_up_heapify(self, idx):
        parent_idx = self.heap.get_parent_idx(idx)
        if parent_idx > 0 and self.heap.get_value(idx) < self.heap.get_value(parent_idx):
            self.heap.swap(idx, parent_idx)
            self.__bottom_up_heapify(parent_idx)

    def __is_heap_empty(self):
        if self.heap.is_empty():
            return True
        else:
            return False


class MaxHeap:

    def __init__(self):
        self.heap = HeapList()

    def delete(self, num):  # num을 힙에서 찾아서 삭제
        pass

    def pop(self):  # 최댓값을 삭제하는 연산
        pass

    def insert(self, num):  # 삽입 연산
        pass

    def __heapify(self):
        pass

    def __is_heap_empty(self):
        if self.heap.is_empty():
            return True
        else:
            return False


class HeapList:
    def __init__(self):
        self.li = [0]

    def print_heap(self):
        print(self.li)

    def is_empty(self):
        if len(self.li) == 1:
            return True
        else:
            return False

    def swap(self, idx1, idx2):
        self.li[idx1], self.li[idx2] = self.li[idx2], self.li[idx1]

    def pop(self):
        ret = self.li[-1]
        del self.li[-1]
        return ret

    def append(self, num):
        self.li.append(num)

    def get_heap_size(self):
        return len(self.li) - 1

    def get_value_idx(self, value):
        return self.li.index(value)

    def get_value(self, idx):
        return self.li[idx]

    def get_right_child_idx(self, idx):
        return idx * 2

    def get_left_child_idx(self, idx):
        return idx * 2 + 1

    def get_parent_idx(self, idx):
        return idx // 2

min_heap = MinHeap()

N = int(input())
for _ in range(N):
    cmd = int(input())
    if cmd == 0:
        a = min_heap.pop()
        if a is not None:
            print(a)
    elif cmd == -1:
        print(min_heap.heap)
    else:
        min_heap.insert(cmd)