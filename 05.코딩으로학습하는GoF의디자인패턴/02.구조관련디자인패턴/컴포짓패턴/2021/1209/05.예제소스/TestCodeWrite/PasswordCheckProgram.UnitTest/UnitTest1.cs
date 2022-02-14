using Xunit;
using PasswordCheckProgram.CheckTools;
namespace TestProject;

public class UnitTest1
{
    [Fact]
    public void CorrectPassword()//전체잘못된경우 성공 판별
    { 
        IRule rule = new RuleComposite();
        RuleComposite ruleComposite = new RuleComposite();
        ruleComposite.Add(new IsAlphabetRule());
        ruleComposite.Add(new IsHangleRule());
        ruleComposite.Add(new IsSpaceRule());
        ruleComposite.Add(new IsSpecialWordRule());
        ruleComposite.Add(new IsNumberCountRule());

        string password = "123456789!aA";
        Result result = ruleComposite.Check(password);
        Assert.Equal(true,result.IsSuccess);
    }
    [Fact]
    public void WrongPassword()//전체잘못된경우 실패 판별
    {
        RuleComposite ruleComposite = new RuleComposite();
        ruleComposite.Add(new IsAlphabetRule());
        ruleComposite.Add(new IsHangleRule());
        ruleComposite.Add(new IsSpaceRule());
        ruleComposite.Add(new IsSpecialWordRule());
        ruleComposite.Add(new IsNumberCountRule());

        string password = "1234";
        Result result = ruleComposite.Check(password);
        Assert.Equal(false,result.IsSuccess);
    }
//영문 판별
    [Fact]
    public void SeccessIsAlphabetRuleTest()//결과 성공 판별
    {
        IRule rule = new IsAlphabetRule();
        var password = "AbAAAAA";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(true,result);
    }

    [Fact]
    public void FailIsAlphabetRuleTest()//실패 false판별
    {
        IRule rule = new IsAlphabetRule();
        var password = "A";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(false,result);
    }

    [Fact]
    public void FailMessageSmallIsAlphabetRuleTest()//실패메세지 테스트
    {
        IRule rule = new IsAlphabetRule();
        var password = "A";
        var result = rule.Check(password).Message;
        var expectMessage = "영문 소문자 한개이상 포함해주세요.";
        Assert.Equal(expectMessage,result);
    }
    [Fact]
    public void FailMessageBigIsAlphabetRuleTest()//실패메세지 테스트
    {
        IRule rule = new IsAlphabetRule();
        var password = "a";
        var result = rule.Check(password).Message;
        var expectMessage = "영문 대문자 한개이상 포함해주세요.";
        Assert.Equal(expectMessage,result);
    }
    [Fact]
    public void SuccessMessageIsAlphabetRuleTest()//성공메세지 테스트
    {
        IRule rule = new IsAlphabetRule();
        var password = "Aa";
        var result = rule.Check(password).Message;
        string expectMessage = null;
        Assert.Equal(expectMessage,result);
    }


//한글 판별
    [Fact]
    public void SeccessIsHangleRuleTest()//결과 성공 판별
    {
        IRule rule = new IsHangleRule();
        var password = "AbAAAAA";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(true,result);
    }

    [Fact]
    public void FailIsIsHangleRuleTest()//실패 false판별
    {
        IRule rule = new IsHangleRule();
        var password = "한글";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(false,result);
    }

    [Fact]
    public void FailMessageIsHangleRuleTest()//실패메세지 테스트
    {
        IRule rule = new IsHangleRule();
        var password = "한글";
        var result = rule.Check(password).Message;
        var expectMessage = "한글은 비번으로 설정할 수 없습니다.영문만 입력해주세요.";
        Assert.Equal(expectMessage,result);
    }

    [Fact]
    public void SuccessMessageIsHangleRuleTest()//성공메세지 테스트
    {
        IRule rule = new IsAlphabetRule();
        var password = "Aa";
        var result = rule.Check(password).Message;
        string expectMessage = null;
        Assert.Equal(expectMessage,result);
    }

//숫자갯수 판별
    [Fact]
    public void SeccessIsNumberCountRuleTest()//결과 성공 판별
    {
        IRule rule = new IsNumberCountRule();
        var password = "12345678";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(true,result);
    }

    [Fact]
    public void FailIsIsNumberCountRuleTest()//실패 false판별
    {
        IRule rule = new IsNumberCountRule();
        var password = "123";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(false,result);
    }

    [Fact]
    public void FailMessageIsNumberCountRuleTest()//실패메세지 테스트
    {
        IRule rule = new IsNumberCountRule();
        var password = "123";
        var result = rule.Check(password).Message;
        var expectMessage = "8자리 이상 입력해주세요.";
        Assert.Equal(expectMessage,result);
    }

    [Fact]
    public void SuccessMessageIsNumberCountRuleTest()//성공메세지 테스트
    {
        IRule rule = new IsNumberCountRule();
        var password = "12345678";
        var result = rule.Check(password).Message;
        string expectMessage = null;
        Assert.Equal(expectMessage,result);
    }
//스페이스 판별
    [Fact]
    public void SeccessIsSpaceRuleTest()//결과 성공 판별
    {
        IRule rule = new IsSpaceRule();
        var password = "abcd";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(true,result);
    }

    [Fact]
    public void FailIsIsSpaceRuleTest()//실패 false판별
    {
        IRule rule = new IsSpaceRule();
        var password = "ab cd";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(false,result);
    }

    [Fact]
    public void FailMessageIsSpaceRuleTest()//실패메세지 테스트
    {
        IRule rule = new IsSpaceRule();
        var password = "ab cd";
        var result = rule.Check(password).Message;
        var expectMessage = "공백을 허용하지 않습니다";
        Assert.Equal(expectMessage,result);
    }

    [Fact]
    public void SuccessMessageIsSpaceRuleTest()//성공메세지 테스트
    {
        IRule rule = new IsSpaceRule();
        var password = "abcd";
        var result = rule.Check(password).Message;
        string expectMessage = null;
        Assert.Equal(expectMessage,result);
    }
//특수문자 판별
    [Fact]
    public void SeccessIsSpecialWordRuleTest()//결과 성공 판별
    {
        IRule rule = new IsSpecialWordRule();
        var password = "!@#$%^&&*(";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(true,result);
    }

    [Fact]
    public void FailIsIsSpecialWordRuleTest()//실패 false판별
    {
        IRule rule = new IsSpecialWordRule();
        var password = "12344567";
        var result = rule.Check(password).IsSuccess;
        Assert.Equal(false,result);
    }

    [Fact]
    public void FailMessageIsSpecialWordRuleTest()//실패메세지 테스트
    {
        IRule rule = new IsSpecialWordRule();
        var password = "12344567";
        var result = rule.Check(password).Message;
        var expectMessage = "특수문자를 한글자 이상 포함해주세요.";
        Assert.Equal(expectMessage,result);
    }

    [Fact]
    public void SuccessMessageIsSpecialWordRuleTest()//성공메세지 테스트
    {
        IRule rule = new IsSpecialWordRule();
        var password = "!@#$%^&&*(";
        var result = rule.Check(password).Message;
        string expectMessage = null;
        Assert.Equal(expectMessage,result);
    }
}