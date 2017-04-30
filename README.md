# LinalProgrammingTask
Утилита, выводящая файл для программы решения задач линейного программирования [LinProg](http://linprog.skysense.ru/)

На вход подаётся файл из папки **files**. На первой строчке этого файла указывается количество переменных,
---
на второй - количество ограничений, на третьей - целевая функция, на остальных строчках сами ограничения.
---
Например:
---
на входе подаётся следующий файл(имя файла задаётся пользователем) **mo.txt**:
---
---
5
10
3 8 10 1 4
6 3 8 6 7 4
5 3 6 2 3 10
10 8 1 6 4 9
7 8 4 10 5 3
5 7 7 1 7 9
3 10 3 7 4 3
6 6 3 6 9 2
4 7 8 5 3 3
8 8 5 8 7 7
10 10 2 7 7 7

на выходе в папку **files** генерируется файл(имя файла задаётся пользователем) **mo(result)** для программы [LinProg](http://linprog.skysense.ru/):
[COMMENT]
LinalProgrammingTask
[HEADER]
EXT=MAX
TYPE=STANDARD
[VARIABLES]
X1:INT
X2:INT
X3:INT
X4:INT
X5:INT
[CONSTRAINTS]
6*X1+3*X2+8*X3+6*X4+7*X5=4
5*X1+3*X2+6*X3+2*X4+3*X5=10
10*X1+8*X2+X3+6*X4+4*X5=9
7*X1+8*X2+4*X3+10*X4+5*X5=3
5*X1+7*X2+7*X3+X4+7*X5=9
3*X1+10*X2+3*X3+7*X4+4*X5=3
6*X1+6*X2+3*X3+6*X4+9*X5=2
4*X1+7*X2+8*X3+5*X4+3*X5=3
8*X1+8*X2+5*X3+8*X4+7*X5=7
10*X1+10*X2+2*X3+7*X4+7*X5=7
[GOAL]
3*X1+8*X2+10*X3+X4+4*X5
