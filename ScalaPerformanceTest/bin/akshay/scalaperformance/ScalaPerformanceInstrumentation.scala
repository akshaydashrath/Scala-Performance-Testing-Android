package akshay.scalaperformance

import android.app.Instrumentation
import android.os.Bundle

class ScalaPerformanceInstrumentation extends Instrumentation {
	val LOG_NAME = "ScalaPerformanceTest"

	override def onCreate(arguments: Bundle) {
		super.onCreate(arguments)
		start
	}

}
