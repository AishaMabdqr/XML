package com.example.xml

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler{

    private val details = ArrayList<StudentDetails>()
    private var text : String? = null

    private var id = 0
    private var name = ""
    private var marks = 0

    fun parse(inputStream: InputStream): List<StudentDetails> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", ignoreCase = true) -> {
                            id = text!!.toInt()
                        }
                        tagName.equals("name", ignoreCase = true) -> {
                            name = text!!.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            marks = text!!.toInt()
                        }
                        else -> details.add(StudentDetails(id, name, marks))
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return details
    }


}