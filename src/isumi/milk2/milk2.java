package isumi.milk2;

import java.io.*;
import java.util.*;

/*
ID: osuisum1
LANG: JAVA
TASK: milk2
*/
public class milk2 {
	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int milkMans = Integer.parseInt(f.readLine());
		MilkWorkFlow mk = new MilkWorkFlow();
		for (int i = 0; i < milkMans; i++) {
			StringTokenizer line = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(line.nextToken());
			int end = Integer.parseInt(line.nextToken());
			mk.add(start, end);
		}
		
		out.println(mk.findMaxMilkQuantum() +" "+ mk.findMaxEmptyQuantum());
		out.close();
	}

	static class MilkWorkFlow {
		private List<MilkQuantum> flow = new ArrayList<MilkQuantum>();
		public List<MilkQuantum> getFlow() {
			return flow;
		}
		public void setFlow(List<MilkQuantum> flow) {
			this.flow = flow;
		}
		public void add(int startTime, int endTime) {
			if (this.flow.isEmpty()) {
				this.flow.add(new MilkQuantum(startTime, endTime));
			} else if (endTime < this.flow.get(0).startTime) {
				this.flow.add(0, new MilkQuantum(startTime, endTime));
			} else if (startTime > this.flow.get(this.flow.size() - 1).endTime) {
				this.flow.add(new MilkQuantum(startTime, endTime));
			} else {
				boolean isMerge = false;
				List<MilkQuantum> canMergeIndexs = new ArrayList<>();
				int index = 0;
				for (MilkQuantum m : this.flow) {
					MilkQuantum newOne = new MilkQuantum(startTime, endTime);
					if(m.isIn(newOne.startTime)||m.isIn(newOne.endTime)||newOne.isIn(m.startTime)||newOne.isIn(m.endTime)){
						canMergeIndexs.add(this.flow.get(index));
						isMerge = true;
					}
					index++;
				}
				if (!isMerge) {
					int insertIndex = 0;
					int insertPlace = 0;
					for (MilkQuantum m : this.flow) {
						if (insertIndex - 1 >= 0) {
							MilkQuantum pre = this.flow.get(insertIndex - 1);
							if (startTime > pre.endTime) {
								insertPlace = insertIndex;
								break;
							}
						}
						insertIndex++;
					}
					if (insertPlace != 0) {
						this.flow.add(insertPlace, new MilkQuantum(startTime, endTime));
					}
				}else{
					int minStart = startTime;
					int maxEnd = endTime;
					for(MilkQuantum i:canMergeIndexs){
						minStart = Math.min(i.startTime, minStart);
						maxEnd = Math.max(i.endTime, maxEnd);
						this.flow.remove(i);
					}
					add(minStart, maxEnd);
				}
			}
			this.flow.sort(new Comparator<MilkQuantum>() {
				@Override
				public int compare(MilkQuantum arg0, MilkQuantum arg1) {
					return arg0.startTime - arg1.startTime;
				}
			});
		}

		public int findMaxMilkQuantum() {
			int max = 0;
			for (MilkQuantum m : this.flow) {
				max = Math.max(m.endTime - m.startTime, max);
			}
			return max;
		}

		public int findMaxEmptyQuantum() {
			int max = 0;
			int index = 0;
			for (MilkQuantum m : this.flow) {
				if (index != 0) {
					max = Math.max(m.startTime - this.flow.get(index - 1).endTime, max);
				}
				index++;
			}
			return max;
		}
	}

	static class MilkQuantum {
		public int startTime;
		public int endTime;

		public MilkQuantum(int startTime, int endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public boolean merge(MilkQuantum newOne) {
			if (this.isIn(newOne.startTime) || this.isIn(newOne.endTime) || newOne.isIn(this.startTime) || newOne.isIn(this.endTime)) {
				this.startTime = Math.min(this.startTime, newOne.startTime);
				this.endTime = Math.max(this.endTime, newOne.endTime);
				return true;
			} else {
				return false;
			}
		}

		public boolean isIn(int input) {
			if (input >= this.startTime && input <= this.endTime) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + endTime;
			result = prime * result + startTime;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MilkQuantum other = (MilkQuantum) obj;
			if (endTime != other.endTime)
				return false;
			if (startTime != other.startTime)
				return false;
			return true;
		}
		
		
	}

}
