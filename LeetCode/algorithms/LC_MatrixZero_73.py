def setZeroes( matrix):
    firstRowIsZero = False
    firstColIsZero = False
    for i in matrix[0]:
        if i is 0:
            firstRowIsZero = True
            break

    for i in matrix:
        if i[0] is 0:
            firstColIsZero = True
            break

    for i in range(1,len(matrix)):
        for j in range(1,len(matrix[0])):
            if matrix[i][j] is 0:
                matrix[0][j] = 0
                matrix[i][0] = 0

    for i in range(1,len(matrix)):
        if matrix[i][0] is 0:
            makeRowZero(i,matrix)
    for j in range(1,len(matrix[0])):
        if matrix[0][j] is 0:
            makeColZero(j,matrix)

    if firstRowIsZero:
        makeRowZero(0,matrix)
        matrix[0][0] = 0
    if firstColIsZero:
        makeColZero(0,matrix)
        matrix[0][0] = 0


def makeColZero(col,matrix):
    for i in range(1,len(matrix)):
        matrix[i][col] = 0

def makeRowZero(row,matrix):
    for i in range(1,len(matrix[0])):
        matrix[row][i] = 0

matrix = [[1,2,3,4],[1,2,0,4],[1,2,3,4],[0,2,3,4]]
setZeroes(matrix)
print matrix