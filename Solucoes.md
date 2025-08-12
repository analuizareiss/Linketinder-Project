# Soluções dos Desafios de Linha de Comando Linux

Este documento contém as soluções propostas para todos os 50 desafios (e bônus) do arquivo `README.txt` do pacote `command-line-challenges`.

---

## **1. (B) Extrair challenges.tar.gz**
tar -xzf challenges.tar.gz

## **2. (B) Entrar no diretório challenges**
cd challenges

## **3. (B) Listar conteúdo**
ls

## **4. (B) Criar diretório foo**
mkdir foo

## **5. (I) Criar foo/bar/1/2/3**
mkdir -p foo/bar/1/2/3

## **6. (B) Remover diretório foo**
rm -r foo

## **7. (B) Imprimir "Hello World"**
echo "Hello World" 

## **8. (B) Criar hello.txt com "Hello World"**
echo "Hello World" > hello.txt

## **9. (B) Criar empty.txt (vazio)**
touch empty.txt

## **10. (B) Remover empty.txt** 
rm empty.txt

## **11. (I) Segundo jeito de criar empty.txt**
: > empty.txt 

## **12. (I) Terceiro jeito**
empty.txt

## **13. (B) Copiar hello.txt para goodbye.txt**
cp hello.txt goodbye.txt 

## **14. (B) Renomear goodbye.txt para hello_copy.txt**
mv goodbye.txt hello_copy.txt 

## **15. (I) Verificar se arquivos são idênticos**
diff hello.txt hello_copy.txt 

## **16. (B) Concatenar arquivos em 2_hellos.txt**
cat hello.txt hello_copy.txt > 2_hellos.txt 
 
## **17. (B) Mostrar caminho absoluto**
pwd 

## **18. (B) Listar permissões**
ls -l 

## **19. (B) Adicionar texto em restricted.txt**
echo "texto" >> restricted.txt 

## **20. (B) Executar hello_executable**
./hello_executable 

## **21. (B) Executar challenge_20**
chmod +x challenge_20
./challenge_20

## **22. (B) Compilar e rodar compile_me.c**
gcc compile_me.c -o compile_me && ./compile_me 

## **23. (A) Redirecionar saída de redirect para output.txt**
./redirect > output.txt 2>&1 

## **24. (B) Mostrar data e hora**
date 

## **25. (B) Mostrar processos**
ps aux 

## **26. (B) Número de CPUs**
nproc 

## **27. (B) Versão do kernel**
uname -r 

## **28. (B) Encontrar arquivo com frase específica**
grep -rl "You found the needle in the haystack!" bunch_of_files/ 

## **29. (B) Primeiras 25 linhas de people.csv**
head -n 25 people.csv 

## **30. (B) Últimas 25 linhas**
tail -n 25 people.csv 

## **31. (I) Mostrar diferenças entre greeting1.txt e greeting2.txt**
diff greeting1.txt greeting2.txt 

## **32. (I) Hello -> esperar -> world**
echo "Hello"; sleep 5; echo "world!"

## **33. (I) Criar arquivo 1MB de zeros**
dd if=/dev/zero of=zeros.bin bs=1M count=1 

## **34. (I) Criar arquivo 2MB de dados aleatórios**
dd if=/dev/urandom of=random.bin bs=1M count=2 

## **35. (I) Contar linhas em README.txt**
wc -l README.txt 

## **36. (B) Mostrar README invertido**
tac README.txt 

## **37. (I) Mostrar sobrenomes em people.csv**
cut -d, -f2 people.csv 

## **38. (A) Contar sobrenomes únicos**
cut -d, -f2 people.csv | sort | uniq | wc -l