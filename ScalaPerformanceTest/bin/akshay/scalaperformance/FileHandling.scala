package akshay.scalaperformance

import java.io.File
import java.io.IOException
import java.io.FileWriter
import java.io.BufferedWriter

object FileHandling {

	def writeList(list: List[RandomString]){
		try{
			val file = new File("/sdcard/list.txt")
			file createNewFile
			val out = new BufferedWriter(new FileWriter(file))
			for ( i <- 0 until (list.size-1))
				out write(list(i).num + "," + list(i).s + "\n")
			out close
		}catch {
		case e: IOException => System.err.println("error writing to file")	   }  
	}

	def writeLog(log: String){
		try  
		{  
			val file = new File("/sdcard/Scala.log")
			file createNewFile
			val out = new BufferedWriter(new FileWriter(file))
			out write(log)
			out close
		}  
		catch {   
		case e: IOException => System.err.println("error writing to file")	   }  
	}
}

