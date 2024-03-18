def mymax(iterable, key=lambda x: x):
    # incijaliziraj maksimalni element i maksimalni ključ
    max_x=next(iter(iterable))
    max_key=key(max_x)

    # obiđi sve elemente
    for x in iterable:
        if(key(x) > max_key):
            max_x=x
            max_key = key(x)

    # vrati rezultat
    return max_x




strings = ["Gle", "malu", "vocku", "poslije", "kise", "Puna", "je", "kapi", "pa", "ih", "njise"]
f = lambda x : len(x)

maxint = mymax([1, 3, 5, 7, 4, 6, 9, 2, 0])
maxchar = mymax("Suncana strana ulice")
maxstring = mymax(strings)

D={'burek':8, 'buhtla':5}

print(mymax(strings, f)+" is the longest string in strings array")
print(str(maxint)+" is the largest number in number array")
print(maxchar+" is the largest character in char array")
print(maxstring+" is the largest string in strings array")
maxArticle = mymax(D, D.get)
print("Article with biggest price is "+maxArticle+" with price "+str(D.get(maxArticle)))

persons = [("Aria", "Patel"), ("Ethan", "Rodriguez"), ("Sofia", "Khan"), ("Layla", "Chen"), ("Lucas", "Gomez")]
lastPerson = mymax(persons)
print(lastPerson[0]+" "+lastPerson[1])