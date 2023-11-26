public class RecentPostIterator implements Iterator<Post>{
    
    private Iterator<Post> internalIterator;

    //보드를 알거나 보드가 알고 있는 포스트 목록을 알아야한다.
    //아래예제에서는 보드로 함
    private Board board;

    public RecentPostIterator(Board board){
        List<Post>posts = board.getPosts();
        Collections.sort(posts, (p1,p2)->p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
        this.internalIterator = posts.iterator();
    }

    @Override
    public boolean hasNext(){
        return this.internalIterator.hasNext();
    }

    @Override
    public Post next(){
        return this.internalIterator.next();
    }

}