# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import re

Number = input("Enter the Number:")
Number1 = re.sub(r'[^0-9|\+]', '', Number)

Number2=Number1
#result = re.match("(\+49|0049|0|\+490|00490)(1\d{2}|)(\d*)", Number1)
if (re.match("(\+49|0049|0|00490|[1-9]{1})([1-9]\d{2})(\d*)", Number1)):

    if (Number1[0:1] == "0" or Number1[0:5] == "00490" or Number1[0:4] == "0049" or Number1[0:1] != "0" or Number1[0:3]=="+49"):

        if(Number1[0] is not "0" and Number1[0] != '+'):
           Number1="+49"+Number1[0:]
           Number2=Number1

        elif(Number1[0:3]=="+49"):
            Number2=Number1

        elif (Number1[0:1] is "0" and Number1[1:2] != "0"):
            Number2 = Number1.replace(Number1[0:1], '+49', 1)

        elif (Number1[0:4] == "0049" and Number1[4:5] is not "0"):
            Number2 = Number1.replace(Number1[0:4], '+49', 1)

        elif (Number1[0:5] == "00490"):
            Number2 = Number1.replace(Number1[0:5], '+49', 1)


        if (Number2[3:4] == "1" and Number1[0]=='+' or Number2[3:4] == "1" and Number1[0]=='0'):
            Number2 = Number2[0:3] + " " + Number2[3:6] + " " + Number2[6:]

        elif(Number1[0]!='0'):
            Number2=Number2[0:3]+" "+Number1[3:]


        elif (Number2[3:4] != "0" and Number2[3:4] != "1" and Number1[0]=='+' or Number2[3:4] != "0" and Number2[3:4] != "1" and Number1[0]=='0'):
            Number2 = Number2[0:3] + " " + Number2[3:]

        elif (Number[0] != '0'):
            Number2 = Number2[0:3]+" "+Number1[3:]

        print(Number2)
else:
    print("Invalid Contact Number")