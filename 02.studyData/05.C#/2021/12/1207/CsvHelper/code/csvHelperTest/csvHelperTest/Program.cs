using System;
using System.Globalization;
using System.IO;
using CsvHelper;
using CsvHelper.Configuration;
using CsvHelper.TypeConversion;
using csvHelperTest;

namespace csvHelperTest
{
    class Program
    {
        static void Main(string[] args)
        {
            string _path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop) + @"/csv/file.csv";
            using (var reader = new StreamReader(_path))
            using (var csv = new CsvReader(reader, CultureInfo.InvariantCulture))
            {
                csv.Context.RegisterClassMap<FooMap>();
                var records = csv.GetRecords<Foo>();
            }
        }
    }
    public enum ClassInfo
    {
        oneGrade,
        twoGrade,
        threeGrade
    }
    public class Foo
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public ClassInfo Class { get; set; }
    }
    public sealed class FooMap : ClassMap<Foo>
    {
        public FooMap()
        {
            Map(m => m.Id);
            Map(m => m.Name);
            Map(m => m.Class).TypeConverter<ClassInfoConverter<ClassInfo>>();
        }
    }
    public class ClassInfoConverter<T> : DefaultTypeConverter
    {
        public override object ConvertFromString(string text, IReaderRow row, MemberMapData memberMapData)
        {
           // return ClassInfoConverter.DeserializeObject<T>(text);
           return Enum.Parse<ClassInfo>(text);
        }

        public override string ConvertToString(object value, IWriterRow row, MemberMapData memberMapData)
        {
            //return ClassInfoConverter.SerializeObject(value);
            return value.ToString();
        }
    }
}