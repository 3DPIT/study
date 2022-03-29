#include<stdio.h>
#include<iostream>
#include<string>
int N,M,result;
char boardPlate[11][11]={0,};//입력배열
bool visit[11][11][11][11]={0,};//방문 체크
int finalY,finalX;
struct Data{
    int ry,rx,by,bx,moveCount;
}ball;
void init ()
{
    memset(boardPlate,0,sizeof(boardPlate));
    memset(visit,0,sizeof(visit));
    N=M=finalY=finalX=0;
    result=0x7fffffff;//최소값 저장

    scanf("%d, %d",&N,&M);
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            scanf(" %1c",&boardPlate[i][j]);
            if(boardPlate[i][j]=='B'){
                ball.by=i;
                ball.bx=j;
            }
            else if(boardPlate[i][j]=='R'){
                ball.ry=i;
                ball.rx=j;
            }
            else if(boardPlate[i][j]=='O'){
                finalY=i;
                finalX=j;
            }
        }
    }
    for(int i=0;i<N;i++)
    {for(int j=0;j<M;j++)
    {
        printf("%d ",boardPlate[i][j]);
    }
    printf("\n");
    }
}
int main(void)
{
    init();
    return 0;
}