//package acd.projetos.projeto-1;
/*
compareto
10 | 20 | -1
20 | 10 |  1
10 | 10 |  0
20 | 20 |  0
*/
import java.util.Random;

public class ordenadores 
{
    final int tamanho_vetor;
    private int[] entrada;

    ordenadores(int tamanho_vetor)
    {
        entrada = new int[tamanho_vetor];
        this.tamanho_vetor = tamanho_vetor;
    }

    public void entrada_aleatoria(int max)
    {
        Random random = new Random();
        for (int i = 0 ; i < tamanho_vetor; i++)
        {
            entrada[i] = random.nextInt(max);
        }
    }

    public void entrada_aleatoria(int max, int min)
    {
        Random random = new Random();
        for (int i = 0 ; i < tamanho_vetor; i++)
        {
            entrada[i] = random.nextInt(max-min)+min;
        }
    }

    public void entrada_ordenada()
    {
        for (int i = 0; i < tamanho_vetor; i++)
        {
            entrada[i] = i;
        }
    }

    public void entrada_desordenada()
    {
        for (int j = tamanho_vetor-1, i = 0; i < tamanho_vetor; j--, i++)
        {
            entrada[i] = j;
        }
    }

    public Integer[] entrada_atual()
    {
        Integer B[] = new Integer[tamanho_vetor];
        for (int i = 0; i < tamanho_vetor; i++)
            B[i] = entrada[i];
            
        return B;
    }
    public static <T extends Comparable<T>> T[] bubbleSort(T[] a)
    {
        T[] b = a.clone();
        Boolean flag;
        int tamanho = b.length;
    
        do
        {
            flag = false;
            for (int i = 0; i < tamanho-1; i++)
            {
                if (b[i].compareTo(b[i+1]) > 0)
                {
                    T temp = b[i];
                    b[i] = b[i+1];
                    b[i+1] = temp;
                    flag = true;
                }
            }
        } while (flag == true);    
        
        return b;
    }

    public static <T extends Comparable<T>> T[] insertionsort(T[] a)
    {
        T[] b = a.clone();
        int tamanho = b.length;

        for (int i = 1; i < tamanho; i++)
        {
            T temp = b[i];
            int j;

            for (j = i; j > 0 && b[j-1].compareTo(temp) > 0; j--)
            {
                b[j] = b[j-1];
            }

            b[j] = temp;
    }

    return b;
    }

    public static <T extends Comparable<T>> T[] selectionsort(T[] a)
    {
        T[] b = a.clone();
        int tamanho = b.length;
        T min = b[0]; 
        int i_min = 0;

        for(int i = 0; i > tamanho ; i++)
        {
            for(int j = 0 ; j < tamanho; j++)
            if ( min.compareTo(b[j]) > 0)
            {
                min = b[j];
                i_min = j;
            }
            b[i_min] = b[i];
            b[i] = min;
        }

        return b;
    }

    public static int[] countsort(int[] a)
    {
        int[] b = a.clone();
        int[] bs = new int[b.length];
        int max = 0;
        for(int i = 0; i < b.length ; i++)
            if (b[i] > max)
                max = b[i];
        int[] s = new int[max+1];
            

        for(int i = 0; i < b.length ; i++)
            s[b[i]] += 1;

        for(int i = 1; i < s.length ; i++)
            s[i] += s[i-1]; 


        for(int i = bs.length-1; i >= 0 ; i--)
        {
            bs[s[b[i]]-1] = b[i];
            s[b[i]] -= 1;
        }
            
        return bs;
    }

    public static int[] countsort(int[] a, int max)
    {
        int[] b = a.clone();
        int[] bs = new int[b.length];
        int[] s = new int[max+1];

        for(int i = 0; i < b.length ; i++)
            s[b[i]] += 1;

        for(int i = 1; i < s.length ; i++)
            s[i] += s[i-1]; 

        for(int i = bs.length-1; i >= 0 ; i--)
        {
            bs[s[b[i]]-1] = b[i];
            s[b[i]] -= 1;
        }
            
        return bs;
    }

    public static int[] radix(int[] a)
    {
        int[] b = a;

        return b;
    }
    public static Integer[] int_to_ger(int[] in)
    {
        int[] In = in.clone();
        Integer[] out = new Integer[In.length];

        for(int i = 0 ; i < In.length ;i++)
            out[i] = In[i];
            
        return out;
    }

    public static void outprint(Integer[] in, String prefix)
    {
        System.out.print("\n"+prefix);
        for (int i = 0 ; i < in.length ; i++)
            System.out.print(in[i]+" ");
    }

    public static void main(String[] args) {
     
        int tam = 5;

        ordenadores ordenar = new ordenadores(tam);
        Integer[] entrada;
        Integer[] saida;
        int[] saida_int;
        
        for (int estado = 0 ; estado < 3 ; estado++)
        {
            switch (estado) 
            {
                case 0:
                    ordenar.entrada_ordenada();
                    break;

                case 1:
                    ordenar.entrada_aleatoria(tam);
                    break;

                case 2:
                    ordenar.entrada_desordenada();
                    break;
            
                default:
                    break;
            }
            entrada = ordenar.entrada_atual();
            
            outprint(entrada, "E  : ");
            
            saida = bubbleSort(entrada);
            outprint(saida, "S_b: ");
            
            saida = insertionsort(entrada);
            outprint(saida, "S_i: ");      
            
            saida = selectionsort(entrada);
            outprint(saida, "S_s: ");
            
            saida_int = countsort(ordenar.entrada);
            outprint(int_to_ger(saida_int), "S_c: ");
        }  
    }
}
