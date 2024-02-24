import sys
def solve(lev):
    global sudoku


    n_list=set(range(1,10))

    if lev == zeros:
        for i in sudoku:
            for j in i:
                print(j, end=" ")
            print()
        sys.exit(0)

    for i in range(9):
        for j in range(9):
            if sudoku[i][j] != 0:
                continue
            row = sudoku[i]
            col = [row[j] for row in sudoku]

            divx = i // 3
            divy = j // 3
            room = []
            for p in range(divx * 3, (divx + 1) * 3):
                for q in range(divy * 3, (divy + 1) * 3):
                    room.append(sudoku[p][q])

            row_remain = n_list- set(row)
            col_remain = n_list - set(col)
            room_remain = n_list -set(room)

            #가능한 숫자
            v_list =  list(row_remain & col_remain & room_remain)
            v_list.sort()
            if len(v_list) == 0:
                return False


            for r in range(len(v_list)):
                v=v_list[r]


                if list_check(row, v) and list_check(col, v) and list_check(room, v):
                    # tmp = list(sudoku)
                    sudoku[i][j] = v
                    if solve(lev+1):
                        if lev+1 ==zeros:
                            return
                        pass
                    # v가 마지막 v_list인덱스일때
                    elif r == len(v_list) - 1:
                        sudoku[i][j] = 0
                        return False


    return True
def list_check(list,v):
    if v in list:
        return False
    return True


sudoku = []
zeros = 0

for _ in range(9):
    line = list(map(int,sys.stdin.readline().split()))
    zeros += line.count(0)
    sudoku.append(line)


solve(0)

