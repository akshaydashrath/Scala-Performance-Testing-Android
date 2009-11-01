package akshay.javaperformance;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Debug;

public class JavaPerformanceTest extends Activity{

	Debug.InstructionCount icount = new Debug.InstructionCount();
	String output = "";
	ArrayList<RandomString> list = populateList();
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		startProgram();
		System.err.println(list.size());
		final TextView tv = (TextView)findViewById(R.id.TextView01);
		Button sortList = (Button)findViewById(R.id.Button02);
		Button searchList = (Button)findViewById(R.id.Button03);
		Button exit = (Button)findViewById(R.id.Button04);
		final EditText et = (EditText)findViewById(R.id.EditText01);

		sortList.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				long start = timer();
				list = StoreString.quicksort(list);
				long end = timer();
				writeOutput(start,end,"Sorting = ");
				FileHandling.writeList(list);
				tv.setText("Status: Sorted");
			}
		});

		searchList.setOnClickListener(new OnClickListener(){
		String str = "";
			@Override
			public void onClick(View view){
				long start = timer();
				int i =  StoreString.binarySearch(list, 0, (list.size()-1), et.getText().toString());
				long end = timer();
				writeOutput(start, end, "Searching time = ");
				if (i > -1)
					str = "Element found in position " + i + " in the Array List";
					else if ( i == -1)
						str = "Search unsuccessfull!!";
						tv.setText(str);
						collectResults();
			}
		});

		exit.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				System.exit(1);
			}
		}) ;  
	}

	public void startProgram(){
		icount.resetAndStart();
		Debug.startMethodTracing("jt");
	}

	public ArrayList<RandomString> populateList() {
		Random random = new Random();
		ArrayList<RandomString> list = new ArrayList<RandomString>();
		for (int i = 0; i < 100; i++){
			RandomString rs = new RandomString(random.nextInt(10000),random.nextInt(100));
			list.add(rs);
		}
		return list;
	}

	public void collectResults(){
		if (icount.collect() ) { 
			String totalInstructions = "Total instructions executed: " + icount.globalTotal() + "\n"; 
			output = output + "\n" + totalInstructions;
			String methodInvocations = "Method invocations: " + icount.globalMethodInvocations() + "\n"; 
			output = output + "\n" + methodInvocations; }
		Debug.stopMethodTracing();
		FileHandling.writeLog(output + "");
	}

	public long timer(){return System.currentTimeMillis();}

	public void writeOutput(Long start,Long end,String s){
		output = output + s + (end-start)+ "\n";
	}
}