package mo_ni_shu_zu;
/*����һ��������*/

public class Array {

    int len; //���鳤��
    int cnt; //��ЧԪ�صĸ���
    int[] arr;
    int remove_value; //��¼ɾ����Ԫ�ص�ֵ

    public Array(int len) {
        cnt = 0;  //��ЧԪ�ظ����տ�ʼΪ0,��cntΪ�±��λ����ֵ
        this.len = len;
        arr = new int[len];  //��ʼ�����飬����Ϊlen��ֵ��Ϊ0
    }


    /*�ж������Ƿ�Ϊ��*/
    public boolean is_empty() {
        if (cnt == 0)
            return true;
        else
            return false;
    }

    /*�������*/
    public void show_Array() throws EmptyException{

        if(is_empty()){
            throw new EmptyException("����Ϊ�գ��޷����");
        }else{
            for(int i = 0;i < cnt;i++){
                System.out.println(arr[i]);
            }
        }
    }

    /*�ж������Ƿ���*/
    public boolean is_full(){
        if (cnt == len)
            return true;
        else
            return  false;
    }

    /*����׷��Ԫ��*/
    public boolean append_Array (int value) throws FullException {

        if (is_full()) {
            throw new FullException("�����������޷�׷��");
        }else{
            arr[cnt] = value;
            cnt++;
            return true;
        }
    }

    /*��ĳ���ض�λ�����Ԫ��*/
    public boolean insert_Array(int pos,int value) throws FullException {

        if (is_full()) {
            throw new FullException("�����������޷����");
        }else{
            /*����Ҫ�ڵ�����λ����ӣ�ʵ���������±�Ϊ2�ĵط���ӣ�
              �����һ��λ�õ�Ԫ�ص��±�Ϊ2��Ԫ�أ����������һλ��
              ���ƺ����
            */
            for(int i = cnt;i > pos - 1; i--){
                arr[i] = arr[i-1];
            }
            arr[pos - 1] = value;
            cnt++;  //��Ӻ�����Ԫ�ض�һ������++
            return true;
        }
    }

    /*ɾ��ĳ��λ��Ԫ��*/
    public boolean delect_Array(int pos)throws EmptyException{

        if(is_empty()) {
            throw new EmptyException("����Ϊ�գ��޷�ɾ��");
        }else if(pos < 1 || cnt < pos){  //��Ҫɾ����λ��С��1���ߴ���������ЧԪ�صĸ������򱨴�
            return false;
        } else{
            /*ͬ��ĳ��λ�����Ԫ�أ���ͬ���Ƚ�Ԫ��ɾ�����ٰѺ���λ�õ�Ԫ��������ǰ��һλ*/
            remove_value = arr[pos - 1];
            for(int i = pos;i < cnt;i++) {
                  arr[i - 1] = arr[i];
               }
	    cnt--;
        }
        return true;
    }

    /*����Ԫ�ص��ã��˷�����������ЧԪ�ظ���Ϊ������ż��*/
    public void inversion_Array(){

        int i = 0;
        int j = cnt - 1;  //���һ��Ԫ�ص��±�Ϊcnt-1
        int t;
        while(i < j){
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    /*ʹ��ð�����������������򣨴�С����*/
    public void sort_Array(){

        int t;
        for(int i = cnt - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
}