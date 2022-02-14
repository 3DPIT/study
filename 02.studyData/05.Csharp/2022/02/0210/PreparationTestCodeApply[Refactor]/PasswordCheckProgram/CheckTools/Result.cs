using System.Collections.Generic;

namespace PasswordCheckProgram.CheckTools;

public class Result
{
	private readonly string _message;
	public string Message
	{
		get { return _message; }
	}

	private readonly bool _success;
	public bool IsSuccess
	{
		get { return _success; }
 	}

	private Result()
	{
	}
	// private Result(List<string> messages)
	// {
	// }
	private Result(string message)
	{
		_message = message;
		_success = string.IsNullOrEmpty(message);
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
