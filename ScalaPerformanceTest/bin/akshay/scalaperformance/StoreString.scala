package akshay.scalaperformance

object StoreString {
 
	def quicksort(l: List[RandomString]): List[RandomString] = {
			l match {
			case List() => l
			case _ =>  quicksort(for(x <- l.tail if x.num < l.head.num) yield x) ::: List(l.head) ::: quicksort(for(x <- l.tail if x.num >= l.head.num) yield x)
			}
	}

	def binarySearch(s: String, list: List[RandomString],low: Int, high: Int): Int = {
			(high-low) match {
			case _ if (high-low) > 0 => {
				java.lang.Integer.parseInt(s) match {
				case _ if java.lang.Integer.parseInt(s) < list(low + (high-low)/2).num => binarySearch(s, list, low, low + (high-low)/2)
				case _ if java.lang.Integer.parseInt(s) > list(low + (high-low)/2).num => binarySearch(s, list, (low + (high-low)/2)+1, high)
				case _  => (low + (high-low)/2)+1
				}
			}
			case _ if (high-low) <= 0 => -1
			}
	}
}

