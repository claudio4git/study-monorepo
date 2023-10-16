# -*- coding: utf-8 -*-

# type of variables

valueInteger = 1
valueDouble = 2.6
valueString = "value"
valueBoolean = True

# relational operators

print(valueBoolean == valueDouble)  # there is !=
print(valueDouble > valueBoolean)  # there is <
print(valueBoolean >= valueDouble)  # there is <=

# logical operator

print(valueBoolean == valueInteger and valueString == valueDouble)
print(valueBoolean == valueInteger or valueString == valueDouble)
print(not valueBoolean == valueInteger or valueString == valueDouble)
