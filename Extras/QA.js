function isDFSEqual(tree1, tree2)
{
    if(tree1 === null && tree2 === null) return true;

    if(typeof tree1 != typeof tree2) return false;

    if(!(typeof tree1 === 'object') && !(typeof tree2 == 'object'))
    {
        return tree1 === tree2;
    }

    for(const node in { ...tree1, ...tree2 })
    {
        const isEqual = isDFSEqual(tree1[node], tree2[node]);

        if(!isEqual) return false;
    }

    return true;
}

const tree1 =
{
    Brazil:
    {
        RJ:
        {
            'Rio de Janeiro':
            {
                Copacabana: null
            },
            Itaborai: null
        },
        SP:
        {
            'Sao Paulo':
            {
                'Itaim Bibi': null
            }
        }
    }
};

const tree2 =
{
    Brazil:
    {
        SP:
        {
            'Sao Paulo':
            {
                'Itaim Bibi': null
            }
        },
        RJ:
        {
            Itaborai: null,
            'Rio de Janeiro':
            {
                Copacabana: null
            }
        }
    }
};

const tree3 =
{
    Brazil:
    {
        SP:
        {
            'Sao Paulo':
            {
            }
        },
        RJ:
        {
            Itaborai: null,
            'Rio de Janeiro':
            {
                Copacabana: null
            }
        }
    }
};

const tree4 =
{
    Brazil:
    {
        RJ:
        {
            'Rio de Janeiro':
            {
                Copacabana: null
            },
            Itaborai: null
        },
        SP:
        {
            'Osasco':
            {
                'Itaim Bibi': null
            }
        }
    }
};

console.log(isDFSEqual(tree1, tree2));
console.log(isDFSEqual(tree1, tree3));
console.log(isDFSEqual(tree1, tree4));