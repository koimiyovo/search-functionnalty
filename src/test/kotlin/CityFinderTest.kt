import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class CityFinderTest
{
    @Test
    internal fun `empty referential`()
    {
        val finder = CityFinder(emptyList())

        assertEquals(emptyList(), finder.search("Paris"))
    }

    @Test
    internal fun `search text must be equal or more than 3 characters`()
    {
        val finder = CityFinder(listOf("Paris", "Valencia", "Roma"))

        assertAll(
                { assertEquals(emptyList(), finder.search("")) },
                { assertEquals(emptyList(), finder.search("Pa")) }
        )
    }

    @Test
    internal fun `when search text matches city name then get the city as result`()
    {
        val finder = CityFinder(listOf("Paris", "Valencia", "Roma"))

        assertAll(
                { assertEquals(listOf("Paris"), finder.search("Paris")) },
                { assertEquals(listOf("Roma"), finder.search("Roma")) }
        )
    }

    @Test
    internal fun `search text is case insensitive`()
    {
        val finder = CityFinder(listOf("Paris", "Valencia", "Roma"))

        assertAll(
                { assertEquals(listOf("Paris"), finder.search("paRiS")) },
                { assertEquals(listOf("Roma"), finder.search("ROMA")) }
        )
    }

    @Test
    internal fun `should return all the city names starting with the exact search text`()
    {
        val finder = CityFinder(listOf("Newark", "Valencia", "Roma", "Valence", "New York City"))

        assertAll(
                { assertEquals(listOf("Valencia", "Valence"), finder.search("Val")) },
                { assertEquals(listOf("Newark", "New York City"), finder.search("new")) }
        )
    }

    @Test
    internal fun `should return city names when the search text is just a part of a city name`()
    {
        val finder = CityFinder(listOf("Paris", "Valencia", "Roma", "Budapest", "Bucarest"))

        assertAll({ assertEquals(listOf("Roma"), finder.search("oma")) },
                  { assertEquals(listOf("Roma"), finder.search("Rom")) },
                  { assertEquals(listOf("Budapest"), finder.search("ape")) },
                  { assertEquals(listOf("Budapest", "Bucarest"), finder.search("est")) })
    }

    @Test
    internal fun `when search text is a asterisk then get all cities`()
    {
        val finder = CityFinder(listOf("Paris", "Valencia", "Roma", "Budapest", "Bucarest"))

        assertEquals(listOf("Paris", "Valencia", "Roma", "Budapest", "Bucarest"), finder.search("*"))
    }
}