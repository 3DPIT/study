package sixangleSharpeDeveloper;

public class join {

    /**
     *  ID중복 검사
     *  이메일 중복 검사
     *  대기 상태 User 생성
     *  User 저장
     *  회원생성 명세 추가
     */
    public void register(RegisterRequest req){
        int sameIdCount = userRepository.countById(req.getId());
        if(sameIdCount>0) throw new DupIdException();

        int sameEmailCount = userRepository.countByEmail(req.getEmail());
        if(sameEmailCount >0) throw new DupCmailException();

        User user = User.builder()
                .id(req.getId()).email(req.getEmail())
                .status(PENDING)
                .build();

        userRepository.save(user);

        UserHistory history = userHistory.builder()
                .id(user.getId())
                .status(user.getStatus)
                .timestamp(now())
                .oldStatus(null)
                .build();

        historyDao.insert(history);
    }

    public void registerRefactor(RegisterRequest req){
        checkSameIdExists(req.getId());
        checkSameEmailExists(req.getEmail());
        User user = createPendingUser(req);
        saveUser(user);
        appendNewUserCreatedHistory(user);
    }

    public void checkSameIdExists(String id){
        int sameIdCount = userRepository.countById(req.getId());
        if(sameIdCount>0) throw new DupIdException();
    }

    public void checkSameEmailExists(String email){
        int sameEmailCount = userRepository.countByEmail(req.getEmail());
        if(smaeEamilCount >0) throw new DupEmailException();
    }

    private User createPendingUser(RegisterRequest req){
        return User.builder()
                .id(req.getId()).email(req.getEmail())
                .status(PENDING)
                .build();
    }

    private void saveUser(User User){
        userRepository.save(user);
    }

    private void appendNewUserCreatedHistory(User user){
        UserHistory history = UserHistory.bilder()
                .id(user.getId())
                .status(user.getStatus())
                .timestamp(now())
                .oldStatus(null)
                .build();

        historyDao.insert(history);
    }
}
