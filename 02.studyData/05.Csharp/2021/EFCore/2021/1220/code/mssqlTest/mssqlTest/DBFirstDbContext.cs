using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using mssqlTest.Classes;
namespace mssqlTest
{
    public class DBFirstDbContext :DbContext
    {
        public DBFirstDbContext()
        {
        }

        public DBFirstDbContext(DbContextOptions<DBFirstDbContext> options) : base(options)
        {
        }

        public virtual DbSet<TB_USER1> TB_USER1 { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=localhost;Database=master;User Id=sa;Password=MsSql@Passw0rd;");
        }



        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<TB_USER1>().ToTable(name: "TB_USER1");
        }
    }
}
