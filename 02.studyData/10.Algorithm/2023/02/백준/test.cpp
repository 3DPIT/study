#include <iostream>
#include <queue>
#include <vector>
#define NSIZE 12
#define MSIZE 12
using namespace std;

int N,M;
int ret;
int board[NSIZE][MSIZE];
void COPY(){
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            printf("%d",board[i][j]);
        }
        cout<<endl;
    }
}
void init(){
    N=M=ret=0;
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            scanf("%d",&board[i][j]);
        }
    }
}
void dfs(int y, int x, int cnt){
    if(cnt==3){
        COPY();
        return ;
    }
    for(int i=0;i<N;i++){
        for(int j=x;j<N;j++){
            dfs(i,j,cnt++);
        }
        x=0;
    }
}
void search(){
    queue<int> q;
    dfs(0,0,0);
}
int main() {

    int testCase=1;
    for(int tc=0; tc<testCase;tc++){
        init();
        search();
        printf("#%d %d\n",tc,ret);
    }
    return 0;
}