package basic;

public class SegmentTree {
    int arrLength; //요소 길이
    int tree[]; // 구간합 트리
    public SegmentTree(int arr[]) {
        this.arrLength = arr.length;
        this.tree = new int[arr.length*4];
        init(0, arr.length-1, 1, arr);
    }
    public int init(int start, int end, int node, int arr[]) {
        if(start == end) { /* 리프노드이거나 자식노드들이 구간합이 모두구해졌을 경우 */
            return tree[node] = arr[start]; /* 구간합 트리에 넣어준다 */
        }
        /* 반씩 나눠서  재귀적으로 자식노드들의 구간합을 구해준다 */
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2, arr) + init(mid+1, end, node*2+1, arr);
    }
    public int sum(int start, int end, int node, int left, int right) {
        if(left>end || right < start) {
            return 0;
        }
        if(left <=start && end <=right) {
            return tree[node];
        }
        /* 필요한 구간마다 밑에서부터 구간합을 가지고 올라온다 */
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    public int update(int start, int end, int node, int idx, int value) {
        if(idx < start || end < idx) {
            return tree[node];
        }
        if(start == end && start == idx) {
            return tree[node] = value;
        }

        int mid = (start + end)/2;
        return tree[node] = update(start, mid, node*2, idx, value) + update(mid+1, end, node*2+1, idx, value);
    }

}
