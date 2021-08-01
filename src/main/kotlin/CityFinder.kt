class CityFinder(private val cities: List<String>)
{
    companion object
    {
        const val ALL_CITIES_FILTER = "*"
    }

    fun search(searchText: String): List<String>
    {
        return when
        {
            SearchCriteria(cities, searchText).areMet() -> cities.matches(searchText)
            else                                        -> emptyList()
        }
    }

    private fun List<String>.matches(searchText: String): List<String>
    {
        return when (searchText)
        {
            ALL_CITIES_FILTER -> this
            else              -> filter { it.contains(searchText, true) }
        }
    }
}

class SearchCriteria(private val cities: List<String>, private val searchText: String)
{
    fun areMet() = cities.isNotEmpty() && searchText.isValid()

    private fun String.isValid() = this == CityFinder.ALL_CITIES_FILTER || this.length >= 3
}
