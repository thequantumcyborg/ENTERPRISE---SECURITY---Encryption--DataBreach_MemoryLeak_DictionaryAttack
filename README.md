# ENTERPRISE---SECURITY---Encryption--DataBreach_MemoryLeak_DictionaryAttack
Salting+MD5 Encryption against Data Breach / Memory Leak in OOD Pattern using TDD

Here I demonstrate how data breach can occur from transactions while following object oriented design pattern.
In this demo, a snippet library system is implemented.

Business Process 
Issue a Book: A clerk issues a request to checkout book from a library system. The library system creates association 
with a member and a book. Member info is linked in books list; Likewise, book info is linked in member info. 


[ Sequence design analysis to highlight : potential memory leak from book=issue(member) ]

[ Shopping Cart Case Scenario : passing client object to transaction object with out ecryption leads to access thru transctionList of 
clients [vulnerability-1]; memory leak arising from variable not set null after passing md5+salted ecrypted object further leading to 
dictionary attack [vulnerability-2] ]  
