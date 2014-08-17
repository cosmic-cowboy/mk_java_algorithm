package com.slgerkamp.mkjavaalgorithm.set;

public class IntSet {
	// 集合の容量
	private final int max;
	// 格納されている集合の要素数
	private int num;
	// 集合
	private final int [] set;
	
	public IntSet(int capacity){
		this.num = 0;
		this.max = capacity;
		this.set = new int [capacity];
	}
	
	/**
	 * 探索
	 * @param target
	 * @return インデックス
	 */
	public int indexOf(int target) {
		for(int i = 0; i < num; i++){
			if(set[i] == target){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 存在可否
	 * @param target
	 * @return boolean
	 */
	public boolean contains(int target) {
		return (indexOf(target) != -1) ? true : false;
	}
	
	/**
	 * 要素を追加する<br/>
	 * 要素数が容量と同じ場合、<br/>
	 * すでに登録されている要素の場合<br/>
	 * 追加しない<br/>
	 * @param target
	 * @return
	 */
	public boolean add(int target){
		if(num >= max || contains(target)){
			return false;
		} else {
			set[num++] = target;
			return true;			
		}
	}
	
	/**
	 * 要素の削除<br/>
	 * 要素が空、削除対象の要素がない場合は削除しない<br/>
	 * 削除対象の要素が存在する場合、<br/>
	 * 要素数を減らす<br/>
	 * 削除対象要素のインデックスにその次のインデックスの要素を代入<br/>
	 * これを削除対象の要素のインデックスから最後の要素まで繰り返す<br/>
	 * @param target
	 * @return
	 */
	public boolean remove(int target){
		int index;
		if(num <= 0 || (index = indexOf(target)) > -1){
			return false;
		} else {
			num--;
			for(int i = index; i < num; i++){
				set[i] = set[i+1];
			}
			return true;
		}
	}
	
	/**
	 * targetSetに集合をコピーする
	 * @param targetSet
	 */
	public void copyTo(IntSet targetSet){
		
		// コピーするtargetSetの容量がthis.numより小さい場合は
		// targetSetの容量まで値を代入する
		// 本来はexception投げてよいと思うんだけど
		int copyNum = num > targetSet.max ? targetSet.max : num;
		for(int i = 0; i < copyNum; i++){
			targetSet.set[i] = set[i];
		}
		targetSet.num = copyNum;

	}
	
	/**
	 * targetSetから集合をコピーする
	 * @param targetSet
	 */
	public void copyFrom(IntSet targetSet){
		
		// this.maxがコピーするtargetSetのnumより小さい場合は
		// this.maxの容量まで値を代入する
		// 本来はexception投げてよいと思うんだけど
		int copyNum = targetSet.num > max ? max : targetSet.num;
		
		for(int i = 0; i < copyNum; i++){
			set[i] = targetSet.set[i];
		}
		num = copyNum;
	}
	
	/**
	 * 対象の集合と同じか
	 * @param targetSet
	 * @return
	 */
	public boolean equalsTo(IntSet targetSet){
		if(num != targetSet.num){
			return false;
		}
		// ターゲットの集合との値が同じであるか確認
		// ソートされているわけではないので
		// ひとつずつすべての値を比較する必要がある。
		// ソート用の配列作って比較しちゃったほうが速そうだけど
		for(int i = 0; i < num; i++){
			// 値が存在したかのフラグ
			boolean isMatch = false;
			for(int j = 0; j < targetSet.num; j++){
				if(set[i] == targetSet.set[j]){
					isMatch = true;
					break;
				}
			}
			if(isMatch){
				return false;
			}
		}
		
		return true;
	}


	/**
	 * 2つの集合の和集合
	 * @param firstTargetSet
	 * @param secondTargetSet
	 */
	public void unionOf(IntSet firstTargetSet, IntSet secondTargetSet){
		if(max < (firstTargetSet.num + secondTargetSet.num)){

			copyFrom(firstTargetSet);
			
			for(int i = 0; i < secondTargetSet.num; i++){
				add(secondTargetSet.set[i]);
			}
			
		}
	}
	
	/**
	 * 集合（targetSet）との和集合
	 * 
	 * @param targetSet
	 * @return
	 */
	public boolean add(IntSet targetSet){
		if(targetSet.num > max - num){
			return false;
		} else {
			
			for(int i = 0; i < targetSet.num; i++){
				add(targetSet.set[i]);
			}
			
			return true;
		}
	}
	
	/**
	 * 集合（targetSet）との積集合
	 * 
	 * @param targetSet
	 * @return
	 */
	public boolean retain(IntSet targetSet){
		
		for(int i = 0; i < num; i++){
			boolean isMatch = false;
			for(int j = 0; j < targetSet.num; j++){
				if(set[i] == targetSet.set[j]){
					isMatch = true;
					break;
				}
			}
			if(!isMatch){
				remove(set[i]);
			}
		}
		return true;
	}
	
	/**
	 * 集合（targetSet）との差集合
	 * 
	 * @param targetSet
	 * @return
	 */
	public boolean remove(IntSet targetSet){
		boolean isRemoved = false;
		for(int i = 0; i < targetSet.num; i++){
			if(remove(targetSet.set[i])){
				isRemoved = true;
			};
		}
		
		return isRemoved;
	}
	
	/**
	 * 集合（targetSet）の部分集合であるか
	 * @param targetSet
	 * @return
	 */
	public boolean isSubsetOf(IntSet targetSet){
		
		for(int i = 0; i < num; i++){
			if(!targetSet.contains(set[i])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 集合（targetSet）の真部分集合であるか
	 * @param targetSet
	 * @return
	 */
	public boolean isProperSubsetOf(IntSet targetSet){
		return equalsTo(targetSet);
	}

	/**
	 * firstTargetSet と secondTargetSetの積集合
	 * @param firstTargetSet
	 * @param secondTargetSet
	 */
	public void intersectionOf(IntSet firstTargetSet, IntSet secondTargetSet){
		copyFrom(firstTargetSet);
		retain(secondTargetSet);
	}

	/**
	 * firstTargetSet と secondTargetSetの差集合
	 * @param firstTargetSet
	 * @param secondTargetSet
	 */
	public void differenceOf(IntSet firstTargetSet, IntSet secondTargetSet){
		copyFrom(firstTargetSet);
		remove(secondTargetSet);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		for(int i = 0; i < num; i++){
			buffer.append(set[i] + " ");
		}
		buffer.append("}");
		return buffer.toString();
	}
	/**
	 * 集合の容量
	 * @return
	 */
	public int capacity(){
		return max;
	}
	
	/**
	 * 集合の要素数
	 * @return
	 */
	public int size(){
		return num;
	}
	
	/**
	 * 要素が空か
	 * @return
	 */
	public boolean isEmpty(){
		return num == 0;
	}

	/**
	 * 要素がいっぱいか
	 * @return
	 */
	public boolean isFull(){
		return (num == max);
	}

	/**
	 * 全要素を削除する
	 */
	public void clear(){
		num = 0;
	}


}
