# -*- coding: utf-8 -*-

values = []
values.append(56)

if 56 in values:
    print("yes")

values.append(10)

del values[1]

print(values)

values.append("value")
values.append(5)
values.append(True)
values.append(1)

for value in values:
    print(value)

values.sort()

print(values)
