using Microsoft.Extensions.DependencyInjection;
using System;

namespace mssqlTest
{
    class Program
    {
        static void Main(string[] args)
        {
            DailyPeopleDbQuery dailyPeopleDbQuery = new DailyPeopleDbQuery();
            dailyPeopleDbQuery.Read();
            string connectionString = "server = localhost,1; uid = sa ; pwd = MsSql@Passw0rd; database = master;";

            using (var db = new DBFirstDbContext())
            {

                // Retrieving and displaying data
                Console.WriteLine();
                Console.WriteLine("All departments in the database:");
                foreach (var dept in db.TB_USER1)
                {
                    Console.WriteLine("{0} | {1} | {2}", dept.USER_NO, dept.USER_NAME,dept.START_TIME);
                }
            }
        }
    }
}
