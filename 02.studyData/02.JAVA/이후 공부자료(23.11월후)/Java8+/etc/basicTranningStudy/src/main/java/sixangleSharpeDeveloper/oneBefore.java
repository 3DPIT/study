package sixangleSharpeDeveloper;

import org.springframework.util.StringUtils;

public class oneBefore {
    public void save(SaveRequest req){
        if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수1");
        if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수2");
        if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수3");

        Long seq = repository.createSeq();

        Member member = Member.builder().
                seq(seq).
                id(req.getId()).name(req.getName())email(req.getEmail())
                .createAt(LocalDateTime.now())
                .build();

        repository.save(member);
    }
}

public class oneAfter{
    validate(req);

    Long sea = repostiory.crateSeq();

    Member member = Member.builder()
            .seq(seq)
            .id(req.gerId()).name(req.getName()).email(req.getEamil())
            .createAt(LocalDateTime.now())
            .build();

    repository.save(member);
}

private void validate(SaveRequest req){
    if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수1");
    if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수2");
    if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수3");
}


public class reduceSave(){
    public void save(SaveRequest req){
        validate(req);
        Member member = create(req);
        repository.save(member);
    }

    private void validate(SaveRequest req){
        if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수1");
        if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수2");
        if (!StringUtils.hasText(req.getId()))
            throws new IllegalArgumentException("id는 필수3");
    }

    private Member create(SaveRequest req){
        Long seq  = repository.createSeq();
        return Member.builder()
                .seq(seq);
                .id(req.gerId()).name(req.getName()).email(req.getEamil())
                .createAt(LocalDateTime.now())
                .build();

    }
}