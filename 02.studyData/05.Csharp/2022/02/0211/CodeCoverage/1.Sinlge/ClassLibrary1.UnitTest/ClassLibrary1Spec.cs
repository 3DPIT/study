using Xunit;
using FluentAssertions;

namespace ClassLibrary1.UnitTest;

public class ClassLibrary1Spec
{
    [Fact]
    public void Test1()
    {
        // Arrange
        Class1 sut = new Class1();

        // Act
        int actual = sut.Method0();

        // Assert
        actual.Should().Be(2022);
    }

    [Fact]

    public void Test2()
    {
        // Arrange
        Class1 sut = new Class1();

        // Act
        int actual = sut.Method1();

        // Assert
        actual.Should().Be(2);
    }
}