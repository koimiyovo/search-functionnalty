**Search functionality**

Implement a search functionality to a country UI input field. The function takes a string (search text) as input and
returns the found cities which corresponds to the search text.

Prerequisites Create a collection of strings that will act as a database for the city names.

City names: Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London,
Bangkok, Hong Kong, Dubai, Rome, Istanbul

Requirements

1. If the search text is less than 3 characters, then should return no results. (It is an optimization feature of the
   search functionality.)

2. If the search text is equal or more than 3 characters, then it should return all the city names starting with the
   exact search text

3. The search functionality should be case-insensitive

4. The search functionality should work also when the search text is just a part of a city name

For example “ape” should return “Budapest” city

5. If the search text is a “*” (asterisk), then it should return all the city names.