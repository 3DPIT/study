namespace PasswordProgram.Rules;
public class Result
{
    private readonly List<string> _message = new List<string>();
    public List<string> Message
    {
        get { return _message; }
    }

    private readonly bool _isSuccess;
    public bool IsSuccess
    {
        get { return _isSuccess; }
    }

    private Result() : this(message:null)
    {
    }

    private Result(string message)
    {
        _message.Add(message);
        _isSuccess = string.IsNullOrEmpty(message);
    }

    public static Result Success()
    {
        return new Result();
    }

    public static Result Failure(string message)
    {
        return new Result(message);
    }
}