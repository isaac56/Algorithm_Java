package programmers;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        Tree st = new Tree(stones);
        int answer = Integer.MAX_VALUE;
        for(int i = -1; i < stones.length; i++) {
            if(i+k < stones.length){
                int max = st.max(0, st.arr.length-1, 1, i+1, i+k);
                if(max < answer)
                    answer = max;
            }
        }
        return answer;
    }

    class Tree {
        int arr[]; // 구간합을 만들 요소들
        int tree[]; // 구간합 트리
        public Tree(int arr[]) {
            this.arr = arr;
            this.tree = new int[arr.length*4];
            init(0, arr.length-1, 1);
        }
        public int init(int start, int end, int node) {
            if(start == end) { /* 리프노드이거나 자식노드들이 구간합이 모두구해졌을 경우 */
                return tree[node] = arr[start]; /* 구간합 트리에 넣어준다 */
            }
            /* 반씩 나눠서  재귀적으로 자식노드들의 구간합을 구해준다 */
            int mid = (start+end)/2;
            return tree[node] = Integer.max(init(start, mid, node*2),init(mid+1, end, node*2+1));
        }
        public int max(int start, int end, int node, int left, int right) {
            if(left>end || right < start) {
                return 0;
            }
            if(left <=start && end <=right) {
                return tree[node];
            }
            /* 필요한 구간마다 밑에서부터 구간합을 가지고 올라온다 */
            int mid = (start+end)/2;
            return Integer.max(max(start, mid, node*2, left, right),max(mid+1, end, node*2+1, left, right));
        }
    }
}
