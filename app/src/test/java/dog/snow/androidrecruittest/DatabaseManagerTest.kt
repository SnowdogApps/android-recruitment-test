package dog.snow.androidrecruittest

import dog.snow.androidrecruittest.data.model.raw.MyObjectBox
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawPhoto_
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.photo.Url
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
import junit.framework.TestResult

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File


class DatabaseManagerTest {

    private val TEST_DIRECTORY = File("objectbox-example/test-db")
    private lateinit var boxStore: BoxStore
    private val rawPhoto = RawPhoto(
        0,
        UId(0),
        UId(0),
        Title(""),
        Url(""),
        Url("")
    )

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
        boxStore = MyObjectBox.builder()
            .directory(TEST_DIRECTORY)
            .debugFlags(DebugFlags.LOG_QUERIES or DebugFlags.LOG_QUERY_PARAMETERS)
            .build()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        boxStore.close()
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
    }

    @Test
    fun `check if database is created`() {
        assertFalse(boxStore.isClosed)
    }

    @Test
    fun `insert photo and get photo`() {
        val photoBox =boxStore.boxFor(RawPhoto::class.java)
            photoBox.put(rawPhoto)
        assertEquals(1, photoBox.count())

        val photo = photoBox.query().equal(RawPhoto_.uId, rawPhoto.uId.value).build().find()

        assertEquals(1, photo.size)
        assertEquals(rawPhoto.uId.value, photo[0].uId.value)
    }
}